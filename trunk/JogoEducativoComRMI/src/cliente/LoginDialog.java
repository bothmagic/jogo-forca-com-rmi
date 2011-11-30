package cliente;

import facades.FacadeLogin;
import java.awt.event.KeyEvent;
import java.rmi.RemoteException;
import java.text.ParseException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import pojos.Animal;
import proxy.AcessoProxy;
import servidor.I_RMI;
import servidor.RMI_ServidorSemRegistry;

public class LoginDialog extends javax.swing.JDialog {
    I_RMI servidor;
    
    /** Creates new form LoginDialog */

    LoginDialog() {    
         initComponents();
         this.setLocationRelativeTo(this);
         RMI_ServidorSemRegistry rMI_ServidorSemRegistry = new RMI_ServidorSemRegistry();
         
         FacadeLogin facadeLogin = new FacadeLogin();
         ArrayList dadosFacade = facadeLogin.fachadaLogin();
         servidor = (I_RMI) dadosFacade.get(0);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        user = new javax.swing.JTextField();
        imgLogin = new javax.swing.JLabel();
        abrirJogo = new javax.swing.JButton();
        sair = new javax.swing.JButton();
        senha = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Username:");
        jLabel1.setName("jLabel1"); // NOI18N

        jLabel2.setText("Password:");
        jLabel2.setName("jLabel2"); // NOI18N

        user.setName("user"); // NOI18N

        imgLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cliente/resources/login.jpg"))); // NOI18N
        imgLogin.setName("imgLogin"); // NOI18N

        abrirJogo.setText("Começar a jogar");
        abrirJogo.setName("abrirJogo"); // NOI18N
        abrirJogo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                abrirJogoActionPerformed(evt);
            }
        });

        sair.setText("Sair");
        sair.setName("sair"); // NOI18N
        sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sairActionPerformed(evt);
            }
        });

        senha.setName("senha"); // NOI18N
        senha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                senhaKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(user, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(senha)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(abrirJogo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 193, Short.MAX_VALUE)
                        .addComponent(sair)
                        .addGap(35, 35, 35)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addComponent(imgLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(75, 75, 75))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(user, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(senha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(imgLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(abrirJogo)
                    .addComponent(sair))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sairActionPerformed
        System.exit(-1);
    }//GEN-LAST:event_sairActionPerformed

    private void abrirJogoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_abrirJogoActionPerformed
        this.dispose();
        Animal primeiroAnimal = null;
        ArrayList<Animal> naoContribui = new ArrayList<Animal>();
        try {
           primeiroAnimal = servidor.selectPrimeiroAnimal(naoContribui);
           if(primeiroAnimal == null){
                JOptionPane.showMessageDialog(null, "Não há animais cadastrados para continuar o jogo!\nDesculpa, mas o jogo será encerrado."
                     , "Banco de dados Vazio", JOptionPane.ERROR_MESSAGE);
                System.exit(-1);
           }
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }
        System.out.println("\n\n animal dados: "+primeiroAnimal.toString());
        try {
            new LayoutUsuario(this,primeiroAnimal);
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_abrirJogoActionPerformed

    private void senhaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_senhaKeyPressed
       char c = evt.getKeyChar();
        if  (c == KeyEvent.VK_ENTER) {
            if(!user.getText().equals("")&& !senha.getText().equals("")){
                try {
                    boolean retorno = servidor.autenticaAdmin(user.getText(), senha.getText());
                    
                                    //COMEÇO DA PARTE DO PROXY
                    AcessoProxy acessoProxy = new AcessoProxy(retorno,this);
                    retorno = acessoProxy.permissao();
                                    //FIM DA PARTE DO PROXY
                    if(retorno == false){
                        JOptionPane.showMessageDialog(null,"Usuário ou senha incorretos!", "Erro ao logar", JOptionPane.WARNING_MESSAGE);
                        senha.setText("");
                        user.grabFocus();
                    }
                } catch (RemoteException ex) {
                    ex.printStackTrace();
                }
            }else{
                JOptionPane.showMessageDialog(null,"Todos os campos são obrigatórios!", "Erro ao preencher os campos", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_senhaKeyPressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                LoginDialog dialog = new LoginDialog();
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {

                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton abrirJogo;
    private javax.swing.JLabel imgLogin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton sair;
    public javax.swing.JPasswordField senha;
    private javax.swing.JTextField user;
    // End of variables declaration//GEN-END:variables
}
