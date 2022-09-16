package labno4
import chisel3._
import chisel3.util._
class Branchtask2 extends Bundle{
        val in_A=Input(UInt(32.W))
        val in_B=Input(UInt(32.W))
        val branch=Input(Bool())
        val funct3=Input(UInt(3.W))
        val out=Output(Bool())
    }

class BranchControl1 extends Module{
    val io =IO(new Branchtask2 )
    val out1=false.B
    io.out:=0.U
    
    when (io.funct3==="b000".U){
        when (io.in_A===io.in_B){
            val out1=true.B
            io.out:=out1 && io.branch

            }
        .otherwise{
            val out1 = false.B
            io.out:=out1 && io.branch

        }
        
    }
    
    .elsewhen(io.funct3==="b001".U){
        when (io.in_A=/=io.in_B){
             val out1=true.B
             io.out:=out1 && io.branch


        }
       .otherwise{
           val out1=false.B
           io.out:=out1 && io.branch


       }
    }
    // val out=Mux((io.funct3==="b000".U),true.B,false.B)
    // io.out:=out && io.branch

}


