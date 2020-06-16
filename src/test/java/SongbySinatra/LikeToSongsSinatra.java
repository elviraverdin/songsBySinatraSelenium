package SongbySinatra;

import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class LikeToSongsSinatra extends SongsSinatraParent{
    @Test
    public  void testLikeSong ()
    {
        navegar("https://evening-bastion-49392.herokuapp.com/");
        validarHomePage();
        realizarLoginCorrecto("frank", "sinatra");
        validateSongsPage();
        validarMensajeBienvenida("You are now logged in as frank");
        cerrarBrowser();

    }

}
