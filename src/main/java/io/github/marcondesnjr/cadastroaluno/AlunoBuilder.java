
package io.github.marcondesnjr.cadastroaluno;

import java.time.LocalDate;

/**
 *
 * @author José Marcondes do Nascimento Junior
 */
public class AlunoBuilder {
    private final String nome;
    private final String cpf;
    private final String identidade;
    private String docMilitar;
    private final LocalDate dtNasc;
    private final String nascionalidade;
    private final char sexo;

    public AlunoBuilder(String nome, String cpf, String identidade, LocalDate dtNasc, String nascionalidade, char sexo) {
        this.nome = nome;
        this.cpf = cpf;
        this.identidade = identidade;
        this.dtNasc = dtNasc;
        this.nascionalidade = nascionalidade;
        this.sexo = sexo;
    }
    
    public AlunoBuilder comDocMilitar(String doc) throws DocumentoException{
        if(!temDocMili())
            throw new DocumentoException("Este documento não se aplica á este aluno");
        this.docMilitar = doc;
        return this;
    }
    
    public boolean temDocMili(){
        int idade = LocalDate.now().getYear() - dtNasc.getYear();
        return idade >= 18 && (sexo == 'M' || sexo == 'm');
    }
    
    public Aluno build(){
        return new Aluno(nome, cpf, identidade, docMilitar, dtNasc, nascionalidade,sexo);
    }
}
