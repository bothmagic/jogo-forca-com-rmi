package proxy;

import cliente.LayoutAdministrador;
import cliente.LoginDialog;

public class AcessoProxy implements Subject{
	private boolean temPermissao = false;
        private LoginDialog loginDialog;
	
	public AcessoProxy(boolean permissao,LoginDialog ld){
		this.temPermissao = permissao;
                this.loginDialog = ld;
	}
        
    @Override
    public boolean permissao() {
       if(this.temPermissao == true){
            new LayoutAdministrador(this.loginDialog);
       }
       return temPermissao;
    }

}
