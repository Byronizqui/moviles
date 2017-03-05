/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import java.util.Scanner;

/**
 *
 * @author juandediosmurillomorera
 */
public class Interfaz {
    private final static  Scanner in = new Scanner(System.in);
    
    public static String[] login(){
        String var[] = new String[2];
        System.out.println("Digite su nombre de usuario: ");
        var[0] = in.next();
        System.out.println("\nDigite su contrasena:");
        var[1] = in.next();
        return var;
    }
    public static void welcome(String msg){
        System.out.println("Bienvenido " + msg + "\n");
    }
    
    public static int menuPrincipalAdministrador(){
        int op;
        System.out.println("1. Mantenimiendo de cursos.");
        System.out.println("2. Mantenimiendo de carreras.");
        System.out.println("3. Mantenimiendo de profesores.");
        System.out.println("4. Mantenimiendo de alumnos.");
        System.out.println("5. Oferta academica.");
        System.out.println("6. Matricula.");
        System.out.println("7. Consulta de historial.");
        System.out.println("8. Seguridad.");
        op = in.nextInt();
        return op;
    }
    
    public static int busquedaCurso(){
        int op;
        System.out.println("1. Busqueda por nombre.\n");
        System.out.println("2. Busqueda por codigo.\n");
        System.out.println("3. Busqueda por carrera.\n");
        System.out.println("4. Editar un curso\n");
        op = in.nextInt();
        return op;
    }
    
    public static String nombreCurso(){
        String name;
        System.out.println("Ingrese el nombre: ");
        name = in.nextLine();
        return name;
    }
    
    public static String nombreCodigo(){
        String name;
        System.out.println("Ingrese el codigo: ");
        name = in.nextLine();
        return name;
    }
    
    public static String nombreCarrera(){
        String name;
        System.out.println("Ingrese la carrera: ");
        name = in.nextLine();
        return name;
    }
    
    public static String cedula(){
        String name;
        System.out.println("Ingrese la cedula: ");
        name = in.nextLine();
        return name;
    }
    
    public static int mantenimientoCarreras(){
        int op;
        System.out.println("1. Busqueda por nombre.\n");
        System.out.println("2. Busqueda por codigo.\n");
        System.out.println("3. Editar un carrera\n");
        op = in.nextInt();
        return op;
    }
    
    public static int mantenimientoProfesores(){
        int op;
        System.out.println("1. Busqueda por nombre.\n");
        System.out.println("2. Busqueda por cedula.\n");
        System.out.println("3. Busqueda por carrera.\n");
        System.out.println("4. Editar un curso\n");
        op = in.nextInt();
        return op;
    }
    
    public static int mantenimientoAlumnos(){
        int op;
        System.out.println("1. Busqueda por nombre.\n");
        System.out.println("2. Busqueda por cedula.\n");
        System.out.println("3. Busqueda por carrera.\n");
        System.out.println("4. Editar un curso\n");
        op = in.nextInt();
        return op;
    }
    
    public static int mantenimientoCiclos(){
        int op;
        System.out.println("1. Busqueda por anyo.\n");
        System.out.println("1. Ingresar un ciclo nuevo.\n");
        op = in.nextInt();
        return op;
    }
    
    public static String anyoCiclo(){
        String op;
        System.out.println("Ingrese el anyo a buscar: \n");
        op = in.next();
        return op;
   }
    
   public static String[] cicloNuevo(){
       String var[] = new String[4];
       System.out.println("Anyo del ciclo: \n");
       var[0] = in.next();
       System.out.println("Numero del ciclo: \n");
       var[1] = in.next();
       System.out.println("Fecha de inicio del ciclo: \n");
       var[2] = in.next();
       System.out.println("Fecha de fin del ciclo: \n");
       var[3] = in.next();
       return var;
   }
   
}
