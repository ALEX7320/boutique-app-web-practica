package boutique.com.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import boutique.com.service.MyUserDetailsService;


@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter{
	
	private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
	
	@Autowired
	private MyUserDetailsService userDetailsService;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		auth.userDetailsService(userDetailsService)
		.passwordEncoder(bCryptPasswordEncoder);
	}
	

	@Override
	protected void configure(HttpSecurity http) throws Exception{
		
		
		String ROL_ADMIN= "ADMIN";
		String ROL_CAJERO = "CAJERO";
		String ROL_ALMACEN= "ALMACEN";

				
		http
		.authorizeRequests()
		.antMatchers("/").permitAll()
		.antMatchers("/login").permitAll()       
		
        .antMatchers( // ADMIN
        		"/admin/config"
        		).hasAnyAuthority(ROL_ADMIN)  
        
        .antMatchers( // CLIENTE
        		"/cliente/listar",
        		"/cliente/registrar",
        		"/cliente/listarClientesJson"
        		).hasAnyAuthority(ROL_ADMIN,ROL_CAJERO)  
        
        .antMatchers( // ALMACEN
        		"/almacen/listar",
        		"/almacen/listarIngresosJsonAll",
        		"/almacen/listarSalidasJson_All",
        		"/almacen/listarStockJson"
        		).hasAnyAuthority(ROL_ADMIN,ROL_ALMACEN) 
        
        .antMatchers( // DESCUENTO
        		"/descuento/listar",
        		"/descuento/registrar",
        		"/descuento/listarDescuentosJson"
        		).hasAnyAuthority(ROL_ADMIN,ROL_CAJERO) 
        
        .antMatchers( // EMPLEADO
        		"/empleado/listar",
        		"/empleado/listar/dni",
        		"/empleado/registrar",
                "/empleado/save",
        		"/empleado/eliminar/**",
        		"/empleado/actualizar/**",
        		"/empleado/update"
                ).hasAnyAuthority(ROL_ADMIN) 
        
        .antMatchers( // HORARIO
        		"/horario/listar",
        		"/horario/registrar",
        		"/horario/eliminar"
        		).hasAnyAuthority(ROL_ADMIN)
        
        .antMatchers( // INGRESO
        		"/ingreso/listar",
        		"/ingreso/eliminar",
        		"/ingreso/registrar",
                "/ingreso/listarIngresosJson"
                ).hasAnyAuthority(ROL_ADMIN,ROL_ALMACEN) 
        
        .antMatchers( // PRODUCTO
        		"/producto/listar",
        		"/producto/eliminar",
        		"/producto/registrar",
                "/producto/listarProductosJson"
                ).hasAnyAuthority(ROL_ADMIN,ROL_ALMACEN) 

        .antMatchers( // REPORTE
        		"/reporte/reporte",
        		"/reporte/listar/**",
        		"/reporte/listar",
        		"/proreporteducto/listarReporteVentasJson"
        		).hasAnyAuthority(ROL_ADMIN,ROL_ALMACEN) 
        
        .antMatchers( // SALIDA
        		"/salida/listar",
        		"/salida/eliminar",
        		"/salida/registrar",
                "/salida/listarSalidaJson"
                ).hasAnyAuthority(ROL_ADMIN,ROL_ALMACEN) 
        
        .antMatchers( // VENTA
                "/venta/listar",
                "/venta/eliminarventa",
                "/venta/registrarventa",
                "/venta/eliminardetalleventa",
                "/venta/registrardetalleventa",
                "/venta/listarProductosJson",
                "/venta/listarProductosPorIdVentaJson",
                "/venta/consultaStockJson_All"
                ).hasAnyAuthority(ROL_ADMIN,ROL_CAJERO) 
        
		.anyRequest()
		.authenticated().and().csrf().disable().formLogin()
		.loginPage("/login").failureUrl("/login?error=true")
		.defaultSuccessUrl("/admin/home",true)
		.usernameParameter("username")
		.passwordParameter("password")
		.and().logout()
		.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
		.logoutSuccessUrl("/login")
		.and().exceptionHandling()
		.accessDeniedPage("/error_acceso");
				
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception{
		
		web.ignoring()
		.antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/images/**", "/assets/**");
	
	
	}

}
