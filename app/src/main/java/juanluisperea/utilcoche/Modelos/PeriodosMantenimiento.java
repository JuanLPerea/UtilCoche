package juanluisperea.utilcoche.Modelos;

import java.util.List;

/**
 * Created by TorreJL on 27/04/2017.
 */

public class PeriodosMantenimiento {


    // guardamos cada cuanto tenemos que cambiar cada componente del coche
    private int periodoaceite;
    private int periodofiltroaire;
    private int periodofiltrocombustible;
    private int periodofiltrohabitaculo;
    private int periodocorreasauxiliares;
    private int periodocorreadistribucion;

    public PeriodosMantenimiento(int periodoaceite, int periodofiltroaire, int periodofiltrocombustible, int periodofiltrohabitaculo, int periodocorreasauxiliares, int periodocorreadistribucion) {
        this.periodoaceite = periodoaceite;
        this.periodofiltroaire = periodofiltroaire;
        this.periodofiltrocombustible = periodofiltrocombustible;
        this.periodofiltrohabitaculo = periodofiltrohabitaculo;
        this.periodocorreasauxiliares = periodocorreasauxiliares;
        this.periodocorreadistribucion = periodocorreadistribucion;
    }

    public int getPeriodoaceite() {
        return periodoaceite;
    }

    public void setPeriodoaceite(int periodoaceite) {
        this.periodoaceite = periodoaceite;
    }

    public int getPeriodofiltroaire() {
        return periodofiltroaire;
    }

    public void setPeriodofiltroaire(int periodofiltroaire) {
        this.periodofiltroaire = periodofiltroaire;
    }

    public int getPeriodofiltrocombustible() {
        return periodofiltrocombustible;
    }

    public void setPeriodofiltrocombustible(int periodofiltrocombustible) {
        this.periodofiltrocombustible = periodofiltrocombustible;
    }

    public int getPeriodofiltrohabitaculo() {
        return periodofiltrohabitaculo;
    }

    public void setPeriodofiltrohabitaculo(int periodofiltrohabitaculo) {
        this.periodofiltrohabitaculo = periodofiltrohabitaculo;
    }

    public int getPeriodocorreasauxiliares() {
        return periodocorreasauxiliares;
    }

    public void setPeriodocorreasauxiliares(int periodocorreasauxiliares) {
        this.periodocorreasauxiliares = periodocorreasauxiliares;
    }

    public int getPeriodocorreadistribucion() {
        return periodocorreadistribucion;
    }

    public void setPeriodocorreadistribucion(int periodocorreadistribucion) {
        this.periodocorreadistribucion = periodocorreadistribucion;
    }
}
