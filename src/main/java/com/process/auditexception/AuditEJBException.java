


package com.process.auditexception;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author crixx
 */
public class AuditEJBException  extends AuditException {
    
    private List<String> msgs;
    
    //Para trabajar junto con el ResultRESTBean;
    private String restDetailMessage;

    public AuditEJBException(String message) {
        super(message);
    }

    public AuditEJBException(String message, Throwable cause) {
        super(message, cause);
    }

    public AuditEJBException(String message, List<String> msgs) {
        super(message);
        
        this.msgs = msgs;
    }

    public List<String> getMsgs() {
        return msgs;
    }

    public String getRestDetailMessage() {
        return restDetailMessage;
    }

    public void setRestDetailMessage(String restDetailMessage) {
        this.restDetailMessage = restDetailMessage;
    }
    
    /**
     * Según el tipo de error, se asignará el mensaje de error
     * al atributo restCode y restDetailMessage que son valores
     * que llegará a la vista y con ello se desplegará o no al
     * usuario final.
     * 
     * @see ResultBean 
     * @param e 
     */
    public void handleException(Exception e) {
        //XXX Aquí se debería agregar todos los tipos de errores que van a llegar hasta el usuario.
        if(e instanceof SQLException) {
            SQLException sqlEx = (SQLException) e;

            StringBuilder sb = new StringBuilder();
            sb.append("\n");
            sb.append("   Detalle Error en Persistencia   \n");
            sb.append("===================================\n");
            sb.append("- Error Principal: ").append(sqlEx.getMessage()).append("\n");
            sb.append("- SQL State: ").append(sqlEx.getSQLState()).append("\n");
            sb.append("- SQL Error Code: ").append(sqlEx.getErrorCode()).append("\n");

            if (sqlEx.getNextException() != null) {
                sb.append("- Mensaje Secundario: ").append(sqlEx.getNextException().getMessage()).append("\n");
            } else {
                sb.append("- Mensaje Secundario: null\n");
            }
            
            //if(sqlState.trim().equals("P0001")) { //Error lanzado por el programador "RAISE EXCEPTION".
            if(sqlEx.getMessage().startsWith("[UX]")) {
                restDetailMessage = sb.toString();
            } else {
                restDetailMessage = null;
            }
        }
    }    

    
}
