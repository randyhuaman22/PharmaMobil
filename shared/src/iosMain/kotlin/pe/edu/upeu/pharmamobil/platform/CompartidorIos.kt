package pe.edu.upeu.pharmamobil.platform

import pe.edu.upeu.pharmamobil.domain.platform.Compartidor
import platform.UIKit.UIActivityViewController
import platform.UIKit.UIApplication
import platform.UIKit.UIViewController

class CompartidorIos : Compartidor {

    override fun compartir(texto: String) {
        val controlador = UIActivityViewController(
            activityItems = listOf(texto),
            applicationActivities = null
        )

        controladorVisible(
            UIApplication.sharedApplication.keyWindow?.rootViewController
        )?.presentViewController(controlador, animated = true, completion = null)
    }

    private fun controladorVisible(base: UIViewController?): UIViewController? {
        val presentado = base?.presentedViewController
        return if (presentado != null) controladorVisible(presentado) else base
    }
}
