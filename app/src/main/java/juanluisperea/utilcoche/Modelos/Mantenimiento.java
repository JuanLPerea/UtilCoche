package juanluisperea.utilcoche.Modelos;

import java.util.List;

/**
 * Created by TorreJL on 27/04/2017.
 */

public class Mantenimiento {

    private List aceite;
    private List filtroaire;
    private List filtrocombustible;
    private List filtrohabitaculo;
    private List correasauxiliares;
    private List correadistribucion;
    private boolean estado;

    public Mantenimiento(List aceite, List filtroaire, List filtrocombustible, List filtrohabitaculo, List correasauxiliares, List correadistribucion) {
        this.aceite = aceite;
        this.filtroaire = filtroaire;
        this.filtrocombustible = filtrocombustible;
        this.filtrohabitaculo = filtrohabitaculo;
        this.correasauxiliares = correasauxiliares;
        this.correadistribucion = correadistribucion;
        this.estado = true;
    }

    public List getAceite() {
        return aceite;
    }

    public void setAceite(List aceite) {
        this.aceite = aceite;
    }

    public List getFiltroaire() {
        return filtroaire;
    }

    public void setFiltroaire(List filtroaire) {
        this.filtroaire = filtroaire;
    }

    public List getFiltrocombustible() {
        return filtrocombustible;
    }

    public void setFiltrocombustible(List filtrocombustible) {
        this.filtrocombustible = filtrocombustible;
    }

    public List getFiltrohabitaculo() {
        return filtrohabitaculo;
    }

    public void setFiltrohabitaculo(List filtrohabitaculo) {
        this.filtrohabitaculo = filtrohabitaculo;
    }

    public List getCorreasauxiliares() {
        return correasauxiliares;
    }

    public void setCorreasauxiliares(List correasauxiliares) {
        this.correasauxiliares = correasauxiliares;
    }

    public List getCorreadistribucion() {
        return correadistribucion;
    }

    public void setCorreadistribucion(List correadistribucion) {
        this.correadistribucion = correadistribucion;
    }
}
