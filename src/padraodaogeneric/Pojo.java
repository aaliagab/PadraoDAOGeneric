/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package padraodaogeneric;

import java.util.List;

/**
 *
 * @author Adriel Alejandro
 */
public class Pojo {

    private String nome_class;
    private String pacotePojos;

    public Pojo(String nome_class, String pacotePojos) {
        this.nome_class = nome_class;
        this.pacotePojos = pacotePojos;
    }
    
    public Pojo() {
    }

    public String getId() {
        String id = "Integer";
        return id;
    }

    public String getNomeClass() {
        return nome_class;
    }

    public String getInterfaceDAO() {
        String texto = "";
        if (!getId().equals("Integer") && !getId().equals("")) {
            texto += "package dao;\n"
                    + "\n"
                    + "import " + pacotePojos + "." + getId() + ";\n"
                    + "import " + pacotePojos + "." + getNomeClass() + ";\n"
                    + "\n"
                    + "/**\n"
                    + " *\n"
                    + " * @author aaliagab generate\n"
                    + " */\n"
                    + "public interface " + getNomeInterfaceDAO() + " extends GenericDAO<" + getNomeClass() + ", " + getId() + ">{\n"
                    + "    \n"
                    + "}";
        } else {
            texto += "package dao;\n"
                    + "\n"
                    + "import " + pacotePojos + "." + getNomeClass() + ";\n"
                    + "\n"
                    + "/**\n"
                    + " *\n"
                    + " * @author aaliagab generate\n"
                    + " */\n"
                    + "public interface " + getNomeInterfaceDAO() + " extends GenericDAO<" + getNomeClass() + ", Integer>{\n"
                    + "    \n"
                    + "}";
        }
        return texto;
    }

    public String getClassDAOImplement() {
        String texto = "";
        if (!getId().equals("Integer") && !getId().equals("")) {
            texto += "package dao;\n"
                    + "\n"
                    + "import " + pacotePojos + "." + getId() + ";\n"
                    + "import " + pacotePojos + "." + getNomeClass() + ";\n"
                    + "\n"
                    + "/**\n"
                    + " *\n"
                    + " * @author aaliagab generate\n"
                    + " */\n"
                    + "public class " + getNomeClassDAOImplement() + " extends GenericDAOImplement<" + getNomeClass() + ", " + getId() + "> implements " + getNomeInterfaceDAO() + "{\n"
                    + "    \n"
                    + "}";
        } else {
            texto += "package dao;\n"
                    + "\n"
                    + "import " + pacotePojos + "." + getNomeClass() + ";\n"
                    + "\n"
                    + "/**\n"
                    + " *\n"
                    + " * @author aaliagab generate\n"
                    + " */\n"
                    + "public class " + getNomeClassDAOImplement() + " extends GenericDAOImplement<" + getNomeClass() + ", " + getId() + "> implements " + getNomeInterfaceDAO() + "{\n"
                    + "    \n"
                    + "}";
        }
        return texto;
    }

    public String getNomeInterfaceDAO() {
        return getNomeClass() + "DAO";
    }

    public String getNomeClassDAOImplement() {
        return getNomeClass() + "DAOImplement";
    }

    public String getClassControl(List<String> daoImplementList) {
        String texto = "package controller;\n" + "\n";
        for (String string : daoImplementList) {
            texto += "import dao." + string + ";\n";
        }
        texto += "\n"
                + "/**\n"
                + " *\n"
                + " * @author aaliagab generate\n"
                + " */\n"
                + "public class Control {\n";
        for (String string : daoImplementList) {
            texto += "private "+ string+" " + string.substring(0, string.length() - 9) + ";\n";
        }
        texto += "\n"
                + "    public Control() {\n"
                + "        ";
        for (String string : daoImplementList) {
            texto += string.substring(0, string.length() - 9) + " = new " + string + "();\n        ";
        }
        texto += "}\n"
                + "\n}";
        return texto;
    }
    
    public String listNiveisAcessos(List<String> pojos) {
        String texto = "List<String> nomesNiveis = null;\n";
        for (String string : pojos) {
            texto += "nomesNiveis.add(\""+string+"\");\n";
        }
        return texto;
    }
    

}
