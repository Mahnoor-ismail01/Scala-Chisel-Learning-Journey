package labno5
import chisel3._
import chisel3.util._

class paramEmux[T<:Data](gen:T)(gen1:T) extends Module{
    val io=IO(new Bundle{
        val out=Output(gen)
        val io1=Input(gen)
        val io2=Input(gen1)
        val sel=Input(Bool())
    })

    io.out:=Mux2(io.io1,io.io2,io.sel)
    def  Mux2[T<:Data]( in_0 :T , in_1 :T, sel : Bool ) : T={
        
        Mux(sel,in_0,in_1)
    }
}