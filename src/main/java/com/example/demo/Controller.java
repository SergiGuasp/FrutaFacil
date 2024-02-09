package com.example.demo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.service;

@RestController
public class Controller {

    @Autowired
    private service productoService;

    @GetMapping(value = "products", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Products> obtenerTodosLosProductos() {
            return productoService.obtenerTodosLosProductos();
    }
    @GetMapping(value = "Users", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Users> obtenerTodosLosUsers() {
            return productoService.obtenerTodosLosUsers();
    }
    @GetMapping(value = "About_Us", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<AboutUss> obtenerAboutUs() {
        return productoService.obtenerAboutUs();
    }
    @GetMapping(value = "Contact", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Contacts> obtenerContact() {
        return productoService.obtenerContact();
    }
    @PostMapping(value = "products/add", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> agregarProducto(@RequestBody Products producto) {
        productoService.insertarProducto(producto);
        return ResponseEntity.ok("Producto agregado exitosamente.");
    }
    @PostMapping(value = "users/add", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> addUsers(@RequestBody Users users) {
        productoService.addUsers(users);
        return ResponseEntity.ok("Usuario agregado exitosamente.");
    }

    @PutMapping(value = "products/update", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> actualizarProducto(@RequestBody Products producto) {
        productoService.actualizarProducto(producto);
        return ResponseEntity.ok("Producto actualizado exitosamente.");
    }
    
    @PutMapping(value = "users/update", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> actualizarUser(@RequestBody Users users) {
        productoService.actualizarUser(users);
        return ResponseEntity.ok("Usuario actualizado exitosamente.");
    }

    @DeleteMapping(value = "products/delete/{productId}")
    public ResponseEntity<String> eliminarProducto(@PathVariable Long productId) {
        productoService.eliminarProducto(productId);
        return ResponseEntity.ok("Producto eliminado exitosamente.");
    }
    
    @DeleteMapping(value = "users/delete/{usersId}")
    public ResponseEntity<String> eliminarUsers(@PathVariable Long usersId) {
        productoService.eliminarUsers(usersId);
        return ResponseEntity.ok("Usuario eliminado exitosamente.");
    }
    
    @GetMapping(value = "products/higherThanFive", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Products> obtenerProductosPrecioSuperiorOIgualA5() {
        return productoService.obtenerTodosLosProductosPrecioSuperiorOIgualA5();
    }
    @GetMapping(value = "products/lowerThanFive", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Products> obtenerProductosPrecioInferiorA5() {
        return productoService.obtenerTodosLosProductosPrecioInferiorA5();
    }
    @GetMapping(value = "users/baja", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Users> obtenerTodosLosUsersBaja() {
        return productoService.obtenerTodosLosUsersBaja();
    }
    @GetMapping(value = "buscarUsersLogin", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<?> buscarUsuarioPorNombreYContraseña(@RequestParam String username, @RequestParam String password) {
        if (username == null || password == null) {
            return ResponseEntity.badRequest().body("Los parámetros 'usename' y 'password' son obligatorios.");
        }
        
        Users usuario = productoService.buscarUsuarioPorNombreYContraseña(username, password);
        if (usuario != null) {
            return ResponseEntity.ok(usuario);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciales incorrectas.");
        }
    }



}