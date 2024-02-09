package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.AboutUss;
import com.example.demo.Contacts;
import com.example.demo.Products;
import com.example.demo.Users;
import com.example.demo.dao.Dao;

import java.util.List;
 
@Service
public class service {
 
    @Autowired
    private Dao DAO;
 
    public List<Products> obtenerTodosLosProductos() {
        return DAO.obtenerTodosLosProductos();
    }
    public List<Users> obtenerTodosLosUsers() {
        return DAO.obtenerTodosLosUsers();
    }
    public List<AboutUss> obtenerAboutUs() {
        return DAO.obtenerAboutUs();
    }
    public List<Contacts> obtenerContact() {
        return DAO.obtenerContact();
    }
    public void insertarProducto(Products producto) {
    	DAO.insertarProducto(producto);
    }
    
    public void addUsers(Users users) {
    	DAO.addUsers(users);
    }

    public void actualizarProducto(Products producto) {
    	DAO.actualizarProducto(producto);
    }
    
    public void actualizarUser(Users users) {
    	DAO.actualizarUser(users);
    }
    
    public void eliminarProducto(Long productId) {
    	DAO.eliminarProducto(productId);
    }
    
    public void eliminarUsers(Long usersId) {
    	DAO.eliminarUser(usersId);
    }
    
    public List<Products> obtenerTodosLosProductosPrecioSuperiorOIgualA5() {
        return DAO.obtenerTodosLosProductosPrecioSuperiorOIgualA5();
    }
    public List<Products> obtenerTodosLosProductosPrecioInferiorA5() {
        return DAO.obtenerTodosLosProductosPrecioInferiorA5();
    }
    public List<Users> obtenerTodosLosUsersBaja() {
        return DAO.obtenerTodosLosUsersBaja();
    }
    public Users buscarUsuarioPorNombreYContraseña(String username, String password) {
        return DAO.buscarUsuarioPorNombreYContraseña(username, password);
    }
    

}