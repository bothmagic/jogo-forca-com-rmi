package servidor;

import cliente.populaGridDicas;
import dao.DaoAnimais;
import dao.DaoDicas;
import dao.DaoJogador;
import dao.GenericInsertUpdateDelete;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pojos.Animal;
import pojos.Dicas;
import pojos.Jogador;


public class RMI_Impl extends UnicastRemoteObject  implements I_RMI {
   
    private int vlrMultiplicante = 1000;
    private int vlrCreditos = 10;
    
  public RMI_Impl() throws RemoteException {
    super();
  }

    @Override
    public int atualizaCreditos(int vlrDebitante) throws RemoteException {
        this.setVlrCreditos(vlrCreditos - vlrDebitante);
        return this.getVlrCreditos();
    }
    
    @Override
    public int atualizaVlrMultiplicante(int vlrDebitar)throws RemoteException{
        this.setVlrMultiplicante(vlrMultiplicante - vlrDebitar);
        return this.getVlrMultiplicante();
    }

    @Override
    public String novaDica(List<Integer> dicasJaInformadas) throws RemoteException {
        return "";
    }
    
    @Override
    public Animal novoAnimalJogar(ArrayList<Animal> animaisJaJogados) throws RemoteException {
       return this.selectPrimeiroAnimal(animaisJaJogados);
    }
    
    @Override
    public int gravaAnimal(Object animal) throws RemoteException {
       GenericInsertUpdateDelete insertUpdate = new GenericInsertUpdateDelete();
        int vlrReturno = -1;
        try {
           vlrReturno = insertUpdate.insert(animal);
        } catch (NoSuchFieldException ex) {
            vlrReturno = -1;
            ex.printStackTrace();
        } catch (IllegalArgumentException ex) {
            vlrReturno = -1;
            ex.printStackTrace();
        } catch (IllegalAccessException ex) {
            vlrReturno = -1;
            ex.printStackTrace();
        }
        return vlrReturno;
    }

    @Override
    public int gravaDicas(Object dicas) throws RemoteException {
        GenericInsertUpdateDelete insertUpdate = new GenericInsertUpdateDelete();
        int vlrReturno = -1;
        try {
           vlrReturno = insertUpdate.insert(dicas);
        } catch (NoSuchFieldException ex) {
            vlrReturno = -1;
            ex.printStackTrace();
        } catch (IllegalArgumentException ex) {
            vlrReturno = -1;
            ex.printStackTrace();
        } catch (IllegalAccessException ex) {
            vlrReturno = -1;
            ex.printStackTrace();
        }
        return vlrReturno;
    }    

    @Override
    public boolean atualizaAnimal(Object animal) throws RemoteException {
        GenericInsertUpdateDelete genericInsertUpdateDelete = new GenericInsertUpdateDelete();
        boolean retorno = false;
        try {
            retorno = genericInsertUpdateDelete.update(animal);
        } catch (NoSuchFieldException ex) {
            retorno = false;
            ex.printStackTrace();
        } catch (IllegalArgumentException ex) {
            retorno = false;
            ex.printStackTrace();
        } catch (IllegalAccessException ex) {
            retorno = false;
            ex.printStackTrace();
        }
        return retorno;
    }

    @Override
    public boolean deletaAnimal(Animal codAnimal) throws RemoteException {
        GenericInsertUpdateDelete insertUpdateDelete = new GenericInsertUpdateDelete();
        return insertUpdateDelete.delete(codAnimal);
    }

    @Override
    public Animal selectAnimal(String nomeAnimal) throws RemoteException {
        DaoAnimais daoAnimais = new DaoAnimais();
        return daoAnimais.selectUmAnimal(nomeAnimal);
    }

     @Override
    public List<Dicas> selectDicas(String pesq) throws RemoteException {
        DaoDicas daoDicas = new DaoDicas();
        return daoDicas.selectDicaComFiltro(pesq);
    }
    
    @Override
    public List selectDicas() throws RemoteException {
        populaGridDicas gridDicas = new populaGridDicas();
        List listRetornar = null;
        try {
           listRetornar = gridDicas.popula();
        } catch (SQLException ex) {
            listRetornar = null;
            ex.printStackTrace();
        }
        listRetornar.toString();
        return listRetornar;
    }

    @Override
    public boolean autenticaAdmin(String usuario, String senha) throws RemoteException {
        boolean vlrRetorno = false;
        if(usuario.equalsIgnoreCase("jogoEducativo") && senha.equalsIgnoreCase("jogoEducativo")){
            vlrRetorno = true;
        }
        return vlrRetorno;
    }

    @Override
    public Animal selectPrimeiroAnimal(ArrayList<Animal> animaisJaJogados) throws RemoteException {
        DaoAnimais daoAnimais = new DaoAnimais();
        return daoAnimais.selectRandomAnimal(animaisJaJogados); 
    }

    @Override
    public int gravaJogador(Object jogador) throws RemoteException {
        GenericInsertUpdateDelete insertUpdateDelete = new GenericInsertUpdateDelete();
        int vlrRetorno = -1;
        try {
            vlrRetorno = insertUpdateDelete.insert(jogador);
        } catch (NoSuchFieldException ex) {
            ex.printStackTrace();
        } catch (IllegalArgumentException ex) {
            ex.printStackTrace();
        } catch (IllegalAccessException ex) {
            ex.printStackTrace();
        }
        if(vlrRetorno > 0){
            DaoJogador daoJogador = new DaoJogador();
            List selectOrdenado = daoJogador.selectOrdenado();
            for (int i = 0; i < selectOrdenado.size(); i++) {
                if(vlrRetorno == ((Jogador)selectOrdenado.get(i)).getCodigo()){
                    vlrRetorno = i+1;
                    break;
                }
            }
        }       
      return vlrRetorno;
    }
    
    @Override
    public List retornaRanking()throws RemoteException{
        DaoJogador daoJogador = new DaoJogador();
        return daoJogador.selectOrdenado();
    }

    @Override
    public List selectJogador(String nomePesq)throws RemoteException{
        DaoJogador daoJogador = new DaoJogador();
        return daoJogador.selectJogador(nomePesq);
    }
    
    public int getVlrMultiplicante() {
        return vlrMultiplicante;
    }

    public void setVlrMultiplicante(int vlrMultiplicante) {
        this.vlrMultiplicante = vlrMultiplicante;
    }

    public int getVlrCreditos() {
        return vlrCreditos;
    }

    public void setVlrCreditos(int vlrCreditos) {
        this.vlrCreditos = vlrCreditos;
    }
        
}