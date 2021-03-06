package io.github.marcondesnjr.cadastroaluno;

import br.com.caelum.stella.validation.CPFValidator;
import br.com.caelum.stella.validation.InvalidStateException;
import io.github.marcondesnjr.cadastroaluno.exceptions.PreexistingEntityException;
import io.github.marcondesnjr.namevalidator.NameValidator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author José Marcondes do Nascimento Junior
 */
public class CadastrarAluno {
    
    public static void cadastrarNovo(Aluno al) throws AlunoInvalidoException{
        if(!NameValidator.isValid(al.getNome()))
            throw new AlunoInvalidoException("O aluno deve possuir um nome válido");
        if(al.getDtNasc() == null)
            throw new AlunoInvalidoException("O aluno deve possuir uma data de nascimento válida");
        if(al.getIdentidade() == null || al.getIdentidade().equals(""))
            throw new AlunoInvalidoException("O aluno deve possuir uma identidade válida");
        if(al.getNascionalidade() == null || al.getNascionalidade().equals(""))
            throw new AlunoInvalidoException("O aluno deve possuir uma nascionalidade válida");
        if((al.getDocMilitar() == null &&(al.getSexo() == 'M' && al.getIdade() >= 18)) ||
                al.getDocMilitar() != null && al.getDocMilitar().equals(""))
            throw new AlunoInvalidoException("O aluno deve possuir um documento militar válido");
        if(al.getSexo() != 'M' && al.getSexo() != 'F')
            throw new AlunoInvalidoException("O aluno deve possuir um sexo válido");
        try{
            new CPFValidator().assertValid(al.getCpf());
        }catch(InvalidStateException ex){
            throw new AlunoInvalidoException("O aluno deve possuir um CPF válido");
        }
        EntityManagerFactory manager = Persistence.createEntityManagerFactory("io.github.marcondesnjr_cadastro-alunoPU");
        AlunoJpaController alJpa = new AlunoJpaController(manager);
        try{
        alJpa.create(al);
        manager.close();
        }catch(PreexistingEntityException ex){
            manager.close();
            throw new AlunoInvalidoException("Este aluno já está cadastrado no sistema");
        } catch (Exception ex) {
            manager.close();
            Logger.getLogger(CadastrarAluno.class.getName()).log(Level.SEVERE, null, ex);
            throw new AlunoInvalidoException("Ocorreu um erro no cadastro");
        }
    }
    
    public static Aluno localizaAluno(String cpf){
        EntityManagerFactory manager = Persistence.createEntityManagerFactory("io.github.marcondesnjr_cadastro-alunoPU");
        AlunoJpaController alJpa = new AlunoJpaController(manager);
        Aluno result =  alJpa.findAluno(cpf);
        manager.close();
        return result;
    }
        
}
