/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.marcondesnjr.cadastroaluno;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author José Marcondes do Nascimento Junior
 */
@Entity
public class Aluno implements Serializable {
    private static final long serialVersionUID = 1L;
    private String nome;
    @Id
    private String cpf;
    private String identidade;
    private String docMilitar;
    private LocalDate dtNasc;
    private String nascionalidade;
    private char sexo;

    protected Aluno() {
    }
    

    protected Aluno(String nome, String cpf, String identidade, String docMilitar, LocalDate dtNasc,
            String nascionalidade, char sexo) {
        this.nome = nome;
        this.cpf = cpf;
        this.identidade = identidade;
        this.docMilitar = docMilitar;
        this.dtNasc = dtNasc;
        this.nascionalidade = nascionalidade;
        this.sexo = sexo;
    }

    public String getNome() {
        return nome;
    }

    public String getIdentidade() {
        return identidade;
    }

    public String getDocMilitar() {
        return docMilitar;
    }

    public LocalDate getDtNasc() {
        return dtNasc;
    }

    public String getNascionalidade() {
        return nascionalidade;
    }
        

    public String getCpf() {
        return cpf;
    }

    public char getSexo() {
        return sexo;
    }
    
    public int getIdade(){
        return LocalDate.now().getYear() - dtNasc.getYear();
    }
    
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cpf != null ? cpf.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Aluno)) {
            return false;
        }
        Aluno other = (Aluno) object;
        if ((this.cpf == null && other.cpf != null) || (this.cpf != null && !this.cpf.equals(other.cpf))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "io.github.marcondesnjr.cadastroaluno.Aluno[ id=" + cpf + " ]";
    }
    
}
