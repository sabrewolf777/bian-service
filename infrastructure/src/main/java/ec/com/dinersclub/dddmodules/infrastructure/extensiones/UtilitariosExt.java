package ec.com.dinersclub.dddmodules.infrastructure.extensiones;

public final class UtilitariosExt {

    public  static boolean esPeticionBcoPichincha(String codAplicRequest,String codPortalResquet,String codAplicConfigMap,String codPortalConfigMap)
    {
        if((codAplicRequest.equals(codAplicConfigMap))&&(codPortalResquet.equals(codPortalConfigMap)))
            return true;
        return false;
    }
}
