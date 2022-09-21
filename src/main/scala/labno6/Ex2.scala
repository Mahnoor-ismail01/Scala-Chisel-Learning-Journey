package labno6
import chisel3._
import chisel3.util._

class Counter6(val max :Int, val min :Int=0) extends Module{
    val io=IO(new Bundle{
        val out =Output(UInt(log2Ceil(max).W))
    })
    val counter =RegInit(min.U(log2Ceil(5).W))//log2Ceil =size of a word
val count_buffer=Mux ( isPow2 ( max ).B && ( min ==0).B, counter +1. U , Mux ( counter ===
max .U , min .U , counter +1. U ) )//skip comparator and mux
//otherwise

print(isPow2(max))
print(max)

counter:=count_buffer
io.out:=counter
}