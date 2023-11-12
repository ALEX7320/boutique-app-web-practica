
-- SALIDA: salida -> producto
ALTER TABLE `db_boutique_mvc`.`salida` 
DROP FOREIGN KEY `fk_salida_producto1`;
ALTER TABLE `db_boutique_mvc`.`salida` 
ADD CONSTRAINT `fk_salida_producto1`
    FOREIGN KEY (`producto_id`)
    REFERENCES `db_boutique_mvc`.`producto` (`producto_id`)
    ON DELETE CASCADE;

-- INGRESO: ingreso -> producto
ALTER TABLE `db_boutique_mvc`.`ingreso` 
DROP FOREIGN KEY `fk_ingreso_producto1`;
ALTER TABLE `db_boutique_mvc`.`ingreso` 
ADD CONSTRAINT `fk_ingreso_producto1`
    FOREIGN KEY (`producto_id`)
    REFERENCES `db_boutique_mvc`.`producto` (`producto_id`)
    ON DELETE CASCADE;

-- DETALLEVENTA: detalleventa -> venta
ALTER TABLE `db_boutique_mvc`.`detalleventa` 
DROP FOREIGN KEY `fk_venta_has_producto_venta1`;
ALTER TABLE `db_boutique_mvc`.`detalleventa` 
ADD CONSTRAINT `fk_venta_has_producto_venta1`
    FOREIGN KEY (`venta_id`)
    REFERENCES `db_boutique_mvc`.`venta` (`venta_id`)
    ON DELETE CASCADE;
