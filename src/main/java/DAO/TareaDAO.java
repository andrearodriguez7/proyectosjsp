/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

/**
 *
 * @author Andrea
 */


import entities.Tarea;
import org.hibernate.Session;
import org.hibernate.Transaction;
import Util.HibernateUtil;

import java.util.List;

public class TareaDAO {
    public List<Tarea> listarTareasPorProyecto(int idProyecto) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM Tarea WHERE proyecto.id = :idProyecto", Tarea.class)
              .setParameter("idProyecto", idProyecto)
              .list();

        }
    }

    public void guardarTarea(Tarea tarea) {
        Transaction tx;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            session.save(tarea);
            tx.commit();
        }
    }
    

    public void eliminarTarea(int idTarea) {
        Transaction tx;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            Tarea tarea = session.get(Tarea.class, idTarea);
            if (tarea != null) {
                session.delete(tarea);
            }
            tx.commit();
        }
    }
}