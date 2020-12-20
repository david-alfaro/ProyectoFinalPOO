package alfaroviquez.david.bl.logica;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Optional;
import java.util.Properties;

public class Configuracion {

    private Properties props;
    private boolean cargadas = false;

    public Configuracion() {
        this.props = new Properties();
        try {
            this.props.load(new BufferedReader(new FileReader("application.properties")));
            cargadas = true;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Optional<String> getDriver() {
        if (cargadas)
            return Optional.of((String)this.props.get("DRIVER"));
        else {
            return Optional.empty();
        }
    }



    public Optional<String> getDbURL() {
        if (cargadas)
            return Optional.of((String)this.props.get("DB_URL"));
        else {
            return Optional.empty();
        }
    }

    public Optional<String> getUsrname() {
        if (cargadas)
            return Optional.of((String)this.props.get("USER"));
        else {
            return Optional.empty();
        }
    }

    public Optional<String> getPassword() {
        if (cargadas)
            return Optional.of((String)this.props.get("PWD"));
        else {
            return Optional.empty();
        }
    }
}
