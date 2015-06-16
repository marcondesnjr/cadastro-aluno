/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.marcondesnjr.cadastroaluno;

import java.time.LocalDate;
import java.time.Month;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author José Marcondes do Nascimento Junior
 */
public class CadastrarAlunoTest {
    
    public CadastrarAlunoTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
        
    }

    @Test
    public void testCadastrarNovoNomeInvalido() throws Exception {
        try{
            Aluno a = new AlunoBuilder("José", "117.376.474-78", "123456", LocalDate.now(), "nasc", 'M').build();
            CadastrarAluno.cadastrarNovo(a);
        }catch(AlunoInvalidoException e){
            return;
        }
        fail("Cadastro com nome inválido completo");
    }
    
    @Test
    public void testCadastrarNovoCpfInvalido() throws Exception{
        try{
            Aluno a = new AlunoBuilder("José Marcondes", "117.376.474.78", "123456", LocalDate.now(), "nasc", 'M').build();
            CadastrarAluno.cadastrarNovo(a);
        }catch(AlunoInvalidoException e){
            return;
        }
        fail("Cadastro com cpf inválido completo");
    }
    
    @Test
    public void testCadastrarNovoRGInvalido() throws Exception{
        try{
            Aluno a = new AlunoBuilder("José Marcondes", "117.376.474-78", "", LocalDate.now(), "nasc", 'M').build();
            CadastrarAluno.cadastrarNovo(a);
        }catch(AlunoInvalidoException e){
            return;
        }
        fail("Cadastro com RG invalido completo");
    }
    
    @Test
    public void testCadastrarNovoDtNascInvalida() throws Exception{
        try{
            Aluno a = new AlunoBuilder("José Marcondes", "117.376.474-78", "123123", null, "nasc", 'M').build();
            CadastrarAluno.cadastrarNovo(a);
        }catch(AlunoInvalidoException e){
            return;
        }
        fail("Cadastro com data de nascimento inválida completo");
    }
    
    @Test
    public void testCadastrarNovoNascInvalida() throws Exception{
        try{
            Aluno a = new AlunoBuilder("José Marcondes", "117.376.474-78", "123123", LocalDate.now(), "", 'M').build();
            CadastrarAluno.cadastrarNovo(a);
        }catch(AlunoInvalidoException e){
            return;
        }
        fail("Cadastro com nascionalidade inválido completo");
    }
    
    @Test
    public void testCadastrarNovoSexoInvalido() throws Exception{
        try{
            Aluno a = new AlunoBuilder("José Marcondes", "117.376.474-78", "123123", LocalDate.now(), "nasc", 'w').build();
            CadastrarAluno.cadastrarNovo(a);
        }catch(AlunoInvalidoException e){
            return;
        }
        fail("Cadastro com sexo inválido completo");
    }
    
    @Test
    public void testCadastrarNovoDocumentoInvalido() throws Exception{
        try{
            Aluno a = new AlunoBuilder("José Marcondes", "117.376.474-78", "123123", LocalDate.now(), "nasc", 'M')
                    .comDocMilitar("123123123").build();
            CadastrarAluno.cadastrarNovo(a);
        }catch(AlunoInvalidoException | DocumentoException e){
            return;
        }
        fail("Cadastro com documento inválido completo");
    }
    
    @Test
    public void testCadastrarNovoDocumentoNecessario() throws Exception{
        try{
            Aluno a = new AlunoBuilder("José Marcondes", "117.376.474-78", "123123",
                    LocalDate.of(1995, Month.JUNE, 20), "nasc", 'M').build();
            CadastrarAluno.cadastrarNovo(a);
        }catch(AlunoInvalidoException e){
            return;
        }
        fail("Cadastro com documento necessario completo");
    }
    
    @Test
    public void testCadastrarNovoCorreto() throws Exception{
            Aluno a = new AlunoBuilder("José Marcondes", "117.376.474-78", "123123",
                    LocalDate.of(1995, Month.JUNE, 20), "nasc", 'M').comDocMilitar("123123123").build();
            CadastrarAluno.cadastrarNovo(a);
            assertNotNull(CadastrarAluno.localizaAluno("117.376.474-78"));
    }
}
