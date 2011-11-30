package servidor;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import pojos.Animal;
import pojos.Dicas;

public interface I_RMI extends Remote {

    public void setVlrCreditos(int vlrCreditos)throws RemoteException;
    
    public void setVlrMultiplicante(int vlrMultiplicante)throws RemoteException;
    
    public int atualizaCreditos(int vlrDebitante)throws RemoteException;
    
    public int atualizaVlrMultiplicante(int vlrDebitante)throws RemoteException;
    
    public String novaDica(List<Integer> dicasJaInformadas)throws RemoteException;
    
    public Animal novoAnimalJogar(ArrayList<Animal> animaisJaJogados)throws RemoteException;
    
    public boolean autenticaAdmin(String usuario, String senha)throws RemoteException;
    
    public int gravaAnimal(Object animal)throws RemoteException;
    
    public int gravaDicas(Object dicas)throws RemoteException;
    
    public boolean atualizaAnimal(Object animal)throws RemoteException;
    
   public boolean  deletaAnimal(Animal codAnimal)throws RemoteException;
    
    public Animal selectAnimal(String nomeAnimal)throws RemoteException;
    
    public Animal selectPrimeiroAnimal(ArrayList<Animal> animaisJaJogados)throws RemoteException;
    
    public List selectDicas()throws RemoteException;
    
    public List<Dicas> selectDicas(String pesq)throws RemoteException;

    public int gravaJogador(Object jogador)throws RemoteException;
    
    public List retornaRanking()throws RemoteException;
    
    public List selectJogador(String nomePesq)throws RemoteException;
}
