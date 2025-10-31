package school.sptech;

import school.sptech.especialistas.DesenvolvedorMobile;
import school.sptech.especialistas.DesenvolvedorWeb;

import java.util.ArrayList;
import java.util.List;

public class Consultoria {
    private String nome;
    private Integer vagas;
    private List<Desenvolvedor> desenvolvedores;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getVagas() {
        return vagas;
    }

    public void setVagas(Integer vagas) {
        this.vagas = vagas;
    }

    public Consultoria() {}

    public void contratar(Desenvolvedor desenvolvedor) {
        if (desenvolvedores.size() == getVagas()) {
            return;
        } else {
            desenvolvedores.add(desenvolvedor);
        }
    }

    public void contratarFullstack(DesenvolvedorWeb desenvolvedor) {
        if (desenvolvedor.isFullstack()) {
            desenvolvedores.add(desenvolvedor);
        }
    }

    public Double getTotalSalarios() {
        Double totalSalarios = 0.0;
        for (Desenvolvedor i : desenvolvedores) {
            totalSalarios += i.calcularSalario();
        }
        return totalSalarios;
    }

    public Integer qtdDesenvolvedoresMobile() {
        Integer qtdDesenvolvedorMobile = 0;
        for (int i = 0; i < desenvolvedores.size(); i++) {
            if (desenvolvedores.get(i) instanceof DesenvolvedorMobile)
            qtdDesenvolvedorMobile += 1;
        }
        return qtdDesenvolvedorMobile;
    }

    public List<Desenvolvedor> buscarPorSalarioMaiorIgualQue(Double salario) {
        List<Desenvolvedor> SalarioMaiorIgualQue = new ArrayList<>();

        for (Desenvolvedor i : desenvolvedores) {
            if (i.calcularSalario() > salario) {
                SalarioMaiorIgualQue.add(i);
            }
        }
        return SalarioMaiorIgualQue;
    }

    public Desenvolvedor buscarMenorSalario() {
        if (desenvolvedores.isEmpty()) {return null;}

        Desenvolvedor devMenorSalario = desenvolvedores.get(0);

        for (Desenvolvedor i : desenvolvedores) {
            if (i.calcularSalario() < devMenorSalario.calcularSalario() ) {
                devMenorSalario = i;
            }
        }
        return devMenorSalario;
    }

    public List<Desenvolvedor> buscarPorTecnologia(String tecnologia) {
        List<Desenvolvedor> listaDevs = new ArrayList<>();

        for (Desenvolvedor i : desenvolvedores) {
            if (i instanceof DesenvolvedorWeb) {
                DesenvolvedorWeb devWeb = (DesenvolvedorWeb) i;
                if (tecnologia.equals(devWeb.getBackend()) || tecnologia.equals(devWeb.getFrontend()) || tecnologia.equals(devWeb.getSgbd())) {
                    listaDevs.add(i);
                }
            } else if (i instanceof DesenvolvedorMobile) {
                DesenvolvedorMobile devMob = (DesenvolvedorMobile) i;
                if (tecnologia.equals(devMob.getLinguagem()) || tecnologia.equals(devMob.getPlataforma())) {
                    listaDevs.add(i);
                }
            }
        }
        return listaDevs;
    }

    public Double getTotalSalariosPorTecnologia(String tecnologia) {
        List<Desenvolvedor> listaDesenvolvedores = this.buscarPorTecnologia(tecnologia);
        Double somaTotal = 0.0;

        for (Desenvolvedor i : listaDesenvolvedores) {
            somaTotal += i.calcularSalario();
        }
        return somaTotal;
    }



}
