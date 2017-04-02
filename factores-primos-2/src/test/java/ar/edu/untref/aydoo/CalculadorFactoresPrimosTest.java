package ar.edu.untref.aydoo;

import org.junit.Test;
import org.junit.Assert;


public class CalculadorFactoresPrimosTest 
{
    @Test
    public void CalcularFactoresDe10()
    {
        CalculadorFactoresPrimos calculador = new CalculadorFactoresPrimos();
        int[] factores = calculador.ObtenerFactoresPrimos(10);
        
        Assert.assertEquals(2, factores.length);
        Assert.assertEquals(2, factores[0]);
        Assert.assertEquals(5, factores[1]);
    }
    
    @Test
    public void CalcularFactoresDe90()
    {
        CalculadorFactoresPrimos calculador = new CalculadorFactoresPrimos();
        int[] factores = calculador.ObtenerFactoresPrimos(90);
        
        Assert.assertEquals(4, factores.length);
        Assert.assertEquals(2, factores[0]);
        Assert.assertEquals(3, factores[1]);
        Assert.assertEquals(3, factores[2]);
        Assert.assertEquals(5, factores[3]);
    }
    
    @Test
    public void CalcularFactoresDe360()
    {
        CalculadorFactoresPrimos calculador = new CalculadorFactoresPrimos();
        int[] factores = calculador.ObtenerFactoresPrimos(360);
        
        Assert.assertEquals(6, factores.length);
        Assert.assertEquals(2, factores[0]);
        Assert.assertEquals(2, factores[1]);
        Assert.assertEquals(2, factores[2]);
        Assert.assertEquals(3, factores[3]);
        Assert.assertEquals(3, factores[4]);
        Assert.assertEquals(5, factores[5]);
    }
}
