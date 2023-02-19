package edu.eci.arsw.blueprints.ui;

import edu.eci.arsw.blueprints.model.Blueprint;
import edu.eci.arsw.blueprints.model.Point;
import edu.eci.arsw.blueprints.persistence.BlueprintNotFoundException;
import edu.eci.arsw.blueprints.persistence.BlueprintPersistenceException;
import edu.eci.arsw.blueprints.services.BlueprintsServices;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws BlueprintPersistenceException, BlueprintNotFoundException {
        ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
        BlueprintsServices bs = ac.getBean(BlueprintsServices.class);

        registerBlueprint(bs, "the painting", "john");
        consultBlueprints(bs);
        consultBlueprint(bs, "the painting", "john");
        consultBlueprintByAuthor(bs, "john");
    }

    public static void registerBlueprint(BlueprintsServices bs, String name, String author) throws BlueprintPersistenceException {
        Point[] pts=new Point[]{new Point(0, 0),new Point(10, 10)};
        bs.registerBlueprint(new Blueprint(author, name, pts));
        System.out.println("Registro con exito");
        System.out.println();
    }

    public static void consultBlueprints(BlueprintsServices bs){
        System.out.println("Blueprints existentes:");
        HashSet<Blueprint> set = bs.getAllBlueprints();
        set.forEach(System.out::println);
        System.out.println();
    }

    public static void consultBlueprint(BlueprintsServices bs, String name, String author) throws BlueprintNotFoundException {
        System.out.println("Resultado de la búsqueda para Blueprint "+ name + " del autor "+ author);
        Blueprint b = bs.getBlueprint(author, name);
        System.out.println(b.toString());
        System.out.println();
    }

    public static void consultBlueprintByAuthor(BlueprintsServices bs, String author) throws BlueprintNotFoundException {
        System.out.println("Resultado de la búsqueda para Blueprints del autor "+ author);
        Set<Blueprint> set = bs.getBlueprintsByAuthor(author);
        for (Blueprint b : set){
            System.out.println(b.toString());
            System.out.println();
        }
    }
}
