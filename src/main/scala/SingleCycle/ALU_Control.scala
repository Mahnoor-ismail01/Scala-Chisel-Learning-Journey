package SingleCycle
import chisel3._
import chisel3.util._

class AlU_Control extends Module{
    val io=IO(new Bunlde{
        val AluOp=Input(UInt(3.W))
        val func7=Input(Bool())
        val func3=Input(UInt(3.W))
        val AluControl=Output(UInt(4.W))
    })
    when(AluOp==="b000".U){
        when(func3==="b000".U && func7==="b0".U){
            val AluControl:=0.U
        }
         when(func3==="b000".U && func7==="b1".U){
            val AluControl:=1.U
        }
         when(func3==="b001".U && func7==="b0".U){
            val AluControl:=6.U
        }
         when(func3==="b010".U && func7==="b0".U){
            val AluControl:=5.U
        }
         when(func3==="b011".U && func7==="b0".U){
            val AluControl:=7.U
        }
         when(func3==="b100".U && func7==="b0".U){
            val AluControl:=4.U
        }
         when(func3==="b101".U && func7==="b0".U){
            val AluControl:=8.U
        }
        when(func3==="b101".U && func7==="b1".U){
            val AluControl:=9.U
        }
        when(func3==="b110".U && func7==="b0".U){
            val AluControl:=3.U
        }
        when(func3==="b111".U && func7==="b0".U){
            val AluControl:=2.U
        }


    }
    .elsewhen(AluOp==="b001"){
       when(func3==="b000".U && func7==="b0".U){
            val AluControl:=0.U//add
        }
        when(func3==="b001".U && func7==="b0".U){
            val AluControl:=6.U//slli
        }
        when(func3==="b010".U && func7==="b0".U){
            val AluControl:=6.U//slti
        }
        when(func3==="b011".U && func7==="b0".U){
            val AluControl:7.U//sltiu
        }
        when(func3==="b100".U && func7==="b0".U){
            val AluControl:=4.U//xor
        }
        when(func3==="b101".U && func7==="b0".U){
            val AluControl:=8.U//srl
        }
        when(func3==="b101".U && func7==="b1".U){
            val AluControl:=9.U//sra
        }
        when(func3==="b110".U && func7==="b0".U){
            val AluControl:=3.U//or
        }
        when(func3==="b111".U && func7==="b0".U){
            val AluControl:=2.U//and
        }
    }
    .elsewhen(AluOp==="b010".U){
        when(func3==="b000".U && func7==="b0".U){
            val AluControl:=10.U//beq
        }
        when(func3==="b001".U && func7==="b0".U){
            val AluControl:=11.U//bne
        }
        when(func3==="b100".U && func7==="b0".U){
            val AluControl:=12.U//blt
        }
        when(func3==="b101".U && func7==="b0".U){
            val AluControl:=13.U//bge
        }
        when(func3==="b110".U && func7==="b0".U){
            val AluControl:=14.U//bltu
        }
       
        when(func3==="b111".U && func7==="b0".U){
            val AluControl:=15.U//bgeu
        }

    }
}