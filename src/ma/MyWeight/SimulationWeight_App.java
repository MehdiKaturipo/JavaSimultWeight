package ma.MyWeight;

import ma.MyWeight.dao.WeightDao;
import ma.MyWeight.dao.IDao;
import ma.MyWeight.modéle.Weight;
import ma.MyWeight.métier.IMétierWeight;
import ma.MyWeight.métier.MétierWeight;
import ma.MyWeight.présentation.IWeightControlleur;
import ma.MyWeight.présentation.WeightControlleur;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Properties;
import java.util.Scanner;

public class SimulationWeight_App {
    static Scanner clavier= new Scanner(System.in);
    static IWeightControlleur weightControlleur ;
    private static boolean estUnEntier(String chaine) {
        try {
            Integer.parseInt(chaine);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    public static void test1() {
        var dao = new WeightDao();
        var métier = new MétierWeight();
        var controlleur = new WeightControlleur();

        métier.setWeightDao(dao);
        controlleur.setMétierWeight(métier);
        String reponse = "";
        do {
            System.out.println("==> [Test 1] calcule IMC  de poids <==\n ");
            try {
                String input = "";
                while (true) {
                    System.out.println("Entrer l'Id du poids : ");
                    input = clavier.nextLine();
                    if (estUnEntier(input)) break;
                    System.err.println("Erreur : l'Id du poid doit être un entier");
                }
                long id = Long.parseLong(input);
                controlleur.afficherIMC(id);
            } catch (Exception e) {
                System.out.println("Erreur : " + e.getMessage());
            }
            System.out.println("Voulez vous quittez ? (oui/non) : ");
            reponse = clavier.nextLine();
        } while (!reponse.equalsIgnoreCase("oui"));

        System.out.println("Au revoir ^-^");

    }
    public  static void test2() throws Exception {
         /*IDao<Crédit,Long> dao = null;
         IMétierCrédit métier = null;
         ICréditControlleur créditControlleur = null;*/
        String daoClass;
        String serviceClass;
        String controlleurClass;

        Properties properties = new Properties();
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream config = classLoader.getResourceAsStream("ma/MyWeight/config.properties");

        if (config == null) {
            System.err.println("Erreur : fichier de configuration introuvable");
        } else {
            try {
                properties.load(config);
                daoClass = properties.getProperty("DAO");
                serviceClass = properties.getProperty("SERVICE");
                controlleurClass = properties.getProperty("CONTROLLER");
                config.close();
            } catch (IOException e) {
                throw new Exception("Erreur : impossible de charger le fichier de configuration");
            } finally {
                properties.clear();
            }

            try {
                Class cDao = Class.forName(daoClass);
                Class cMétier = Class.forName(serviceClass);
                Class cControlleur = Class.forName(controlleurClass);
                var dao = (IDao<Weight, Long>) cDao.getDeclaredConstructor().newInstance();
                var métier = (IMétierWeight) cMétier.getDeclaredConstructor().newInstance();
                weightControlleur = (IWeightControlleur) cControlleur.getDeclaredConstructor().newInstance();

                // injection des dependances

                Method setDao = cMétier.getMethod("setWeightDao", IDao.class);
                setDao.invoke(métier, dao);
                Method setMétier = cControlleur.getMethod("setMétierWeight", IMétierWeight.class);
                setMétier.invoke(weightControlleur, métier);
                weightControlleur.afficherIMC(3L);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    public  static void test3() throws Exception{
        ApplicationContext context = new ClassPathXmlApplicationContext("ma/MyWeight/spring-ioc.xml");
        weightControlleur = context.getBean(IWeightControlleur.class);
        weightControlleur.afficherIMC(5L);
    }
    public  static void test4() throws Exception{
        ApplicationContext context = new AnnotationConfigApplicationContext("ma.MyWeight");
        weightControlleur =  context.getBean(IWeightControlleur.class);
        weightControlleur.afficherIMC(5L);
    }
    public static void main (String[] args) throws Exception {
        //test1();
        //test2();
         //test3();
        test4();
    }
}
