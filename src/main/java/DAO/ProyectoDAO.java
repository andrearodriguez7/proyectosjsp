/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

/**
 *
 * @author Andrea
 */

import Util.HibernateUtil;
import entities.Proyecto;
import entities.Tarea;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import org.hibernate.query.Query;

public class ProyectoDAO {

// Método para obtener todos los proyectos
public static List<Proyecto> obtenerTodosProyectos() {
    try (Session session = HibernateUtil.getSessionFactory().openSession()) {
        List<Proyecto> proyectos = session.createQuery("FROM Proyecto", Proyecto.class).list();
        
        // Log para verificar los datos obtenidos
        for (Proyecto p : proyectos) {
            System.out.println("Proyecto: " + p.getNombreProyecto() + " | Estado: " + p.getEstado());
        }
        
        return proyectos;
    }
}


public static List<Proyecto> obtenerProyectosPorEstado(String estado) {
    try (Session session = HibernateUtil.getSessionFactory().openSession()) {
        return session.createQuery("FROM Proyecto WHERE estado = :estado", Proyecto.class)
                .setParameter("estado", estado) // Pasa el String directamente
                .list();
    }
}


    public List<Proyecto> listarProyectos(String estado) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM Proyecto WHERE estado = :estado", Proyecto.class)
                          .setParameter("estado", estado)
                          .list();
        }
    }

    public Proyecto obtenerProyectoPorId(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Proyecto.class, id);
        }
    }

    public void guardarProyecto(Proyecto proyecto) {
        Transaction tx;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            session.save(proyecto);
            tx.commit();
        }
    }

    public void eliminarProyecto(int id) {
        Transaction tx;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            Proyecto proyecto = session.get(Proyecto.class, id);
            if (proyecto != null) {
                session.delete(proyecto);
            }
            tx.commit();
        }
    }

    public List<Proyecto> obtenerTodosLosProyectos() {
        List<Proyecto> proyectos = null;
        Transaction tx = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            proyectos = session.createQuery("FROM Proyecto", Proyecto.class).list();
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }
        
        return proyectos;
    }
}
