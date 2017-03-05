/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import BL.AlumnoBL;
import BL.CarreraBL;
import BL.CursoBL;
import BL.ProfesorBL;
import BL.UsuariosBL;
import Interfaz.Interfaz;
import LogicaNegocio.Alumno;
import LogicaNegocio.Carrera;
import LogicaNegocio.Curso;
import LogicaNegocio.Profesor;
import LogicaNegocio.Usuarios;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Byron
 */
public class Control {

    private UsuariosBL uBL = new UsuariosBL();
    private ProfesorBL pBL = new ProfesorBL();
    private CursoBL cBL = new CursoBL();
    private CarreraBL _cBL = new CarreraBL();
    private AlumnoBL aBL = new AlumnoBL();
    Interfaz i = null;
    public Control() {
    }

    public boolean login() {
        String[] data = Interfaz.login();
        Usuarios u = new Usuarios();
        u.setCedula(data[0]);
        u.setClave(data[1]);
        u = uBL.findByOther(u);
        if (u != null) {
            switch (u.getType()) {
                case 1:
                    administrador(u.getNombre());
                    break;
                default: {
                    Interfaz.welcome(u.getNombre());
                }
            }
            return true;
        }
        return false;
    }

    public void administrador(String name) {
        Interfaz.welcome(name);
        this.menuPrincipalAdministrador();
    }

    public void menuPrincipalAdministrador() {
        int op = Interfaz.menuPrincipalAdministrador();
        switch (op) {
            case 1:
                this.mantenimientoCursos();
                break;
            case 2 : 
                this.mantenimientoCarreras();
            default: {
                this.menuPrincipalAdministrador();
            }
        }
    }

    public void mantenimientoCursos() {
        int op;
        List<Curso> lC = new ArrayList();
        op = Interfaz.busquedaCurso();
        switch (op){
            case 1 : {
                String name = Interfaz.nombreCurso();
                lC = cBL.findAllByOther("name", name);
                this.imprimeCursos(lC);
            }
            break;
            case 2 : {
                String code = Interfaz.nombreCodigo();
                lC = cBL.findAllByOther("code", code);
                this.imprimeCursos(lC);
            }
            break;
            case 3 : {
                String ca = Interfaz.nombreCarrera();
                lC = cBL.findAllByOther("ca", ca);
                this.imprimeCursos(lC);
            }
            case 4 : {
                
            }
            
            default : {
                
            }
        }
    }
    
    public void imprimeCursos(List<Curso> lC){
        String a; 
        for (Curso c : lC){
            a = String.format("Codigo: %s, Nombre: %s, Creditos: %d, Horas: %d\n", 
                    c.getCodigo(), c.getNombre(), c.getCreditos(), c.getHorasSemanles());
            System.out.println(a);
        }
    }
    
    public void mantenimientoCarreras(){
        int op = Interfaz.mantenimientoCarreras();
        List<Carrera> lC = new ArrayList();
        switch (op){
            case 1 : {
                String name = Interfaz.nombreCurso();
                lC = _cBL.findAllByOther("name", name);
                this.imprimeCarreras(lC);
            }
            break;
            case 2 : {
                String code = Interfaz.nombreCodigo();
                lC = _cBL.findAllByOther("code", code);
                this.imprimeCarreras(lC);
            }
            break;
            case 3 : {
                //Editar Carrera
            }
            case 4 : {
                
            }
            
            default : {
                
            }
        }
    }
    
    public void imprimeCarreras(List<Carrera> lC){
        String a; 
        for (Carrera c : lC){
            a = String.format("Codigo: %s, Nombre: %s, Titulo: %s\n", 
                    c.getCodigo(), c.getNombre(), c.getTitulo());
            System.out.println(a);
        }
    }
    
    public void mantenimientoProfesores(){
        int op = Interfaz.mantenimientoProfesores();
        List<Profesor> lP = new ArrayList();
        
        switch (op){
            case 1 : {
                String name = Interfaz.nombreCurso();
                lP = pBL.findAllByOther("name", name);
                this.imprimeProfesores(lP);
            }
            break;
            case 2 : {
                String cedula = Interfaz.cedula();
                lP = pBL.findAllByOther("id", cedula);
                this.imprimeProfesores(lP);
            }
            break;
            
            default : {
                
            }
        }
    }
    
    public void imprimeProfesores(List<Profesor> lP){
        String a; 
        for (Profesor p : lP){
            a = String.format("Cedula: %s, Nombre: %s, Nacimiento: %s, Salario: %.2f\n", 
                    p.getCedula(), p.getNombre(), p.getFechaNac().toString(), p.getSalario());
            System.out.println(a);
        }
    }
    
    public void mantenimientoAlumnos(){
        int op = Interfaz.mantenimientoAlumnos();
        List<Alumno> lA = new ArrayList();
        
        switch (op){
            case 1 : {
                String name = Interfaz.nombreCurso();
                lA = aBL.findAllByOther("name", name);
                this.imprimeAlumnos(lA);
            }
            break;
            case 2 : {
                String cedula = Interfaz.cedula();
                lA = aBL.findAllByOther("code", cedula);
                this.imprimeAlumnos(lA);
            }
            break;
            case 3 : {
                String ca = Interfaz.nombreCarrera();
                lA = aBL.findAllByOther("ca", ca);
                this.imprimeAlumnos(lA);
            }
            case 4 : {
                
            }
            
            default : {
                
            }
        }
    }
    
    public void imprimeAlumnos(List<Alumno> lA){
        String a; 
        for (Alumno al : lA){
            a = String.format("Cedula: %s, Nombre: %s, Nacimiento: %s, Beca: %d\n", 
                    al.getCedula(), al.getNombre(), al.getFechaNac().toString(), al.getBeca());
            System.out.println(a);
        }
    }
    
    public void mantenimientoCiclos(){
        int op = Interfaz.mantenimientoCiclos();
        List<Curso> lC = new ArrayList();
        
        switch (op){
            case 1 : {
                String year = Interfaz.anyoCiclo();
                lC = cBL.findAllByOther("year", year);
                this.imprimeCursos(lC);
            }
            break;
            case 2 : {
                String nombre = Interfaz.cicloNuevo();
                lC = cBL.findAllByOther("name", nombre);
                this.imprimeCursos(lC);
            }
            break;
            case 3 : {
                String ca = Interfaz.nombreCarrera();
                lC = cBL.findAllByOther("ca", ca);
                this.imprimeCursos(lC);
            }            
            default : {
                
            }
        }
    }
}
