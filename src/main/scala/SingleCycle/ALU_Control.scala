package SingleCycle
import chisel3._
import chisel3.util._

class AlU_Control extends Module{
    val io=IO(new Bundle{
        val AluOp=Input(UInt(3.W))
        val func7=Input(Bool())
        val func3=Input(UInt(3.W))
        val AluControl=Output(UInt(5.W))
    })
    io.AluControl:=0.U
    when(io.AluOp==="b000".U){
        when(io.func3==="b000".U && io.func7==="b0".U){
            io.AluControl:=0.U
        }
         when(io.func3==="b000".U && io.func7==="b1".U){
            io.AluControl:=1.U
        }
         when(io.func3==="b001".U && io.func7==="b0".U){
            io.AluControl:=6.U
        }
         when(io.func3==="b010".U && io.func7==="b0".U){
            io.AluControl:=5.U
        }
         when(io.func3==="b011".U && io.func7==="b0".U){
            io.AluControl:=7.U
        }
         when(io.func3==="b100".U && io.func7==="b0".U){
            io.AluControl:=4.U
        }
         when(io.func3==="b101".U && io.func7==="b0".U){
            io.AluControl:=8.U
        }
        when(io.func3==="b101".U && io.func7==="b1".U){
           io.AluControl:=9.U
        }
        when(io.func3==="b110".U && io.func7==="b0".U){
              io.AluControl:=3.U
        }
        when(io.func3==="b111".U && io.func7==="b0".U){
              io.AluControl:=2.U
        }


    }
    .elsewhen(io.AluOp==="b001".U){
       when(io.func3==="b000".U && io.func7==="b0".U){
              io.AluControl:=0.U //add
        }
        when(io.func3==="b001".U && io.func7==="b0".U){
              io.AluControl:=6.U//slli
        }
        when(io.func3==="b010".U && io.func7==="b0".U){
              io.AluControl:=5.U//slti
        }
        when(io.func3==="b011".U && io.func7==="b0".U){
              io.AluControl:=7.U//sltiu
        }
        when(io.func3==="b100".U && io.func7==="b0".U){
              io.AluControl:=4.U//xor
        }
        when(io.func3==="b101".U && io.func7==="b0".U){
              io.AluControl:=8.U//srl
        }
        when(io.func3==="b101".U && io.func7==="b1".U){
              io.AluControl:=9.U//sra
        }
        when(io.func3==="b110".U && io.func7==="b0".U){
              io.AluControl:=3.U//or
        }
        when(io.func3==="b111".U && io.func7==="b0".U){
              io.AluControl:=2.U//and
        }
    }
    .elsewhen(io.AluOp==="b010".U){
        when(io.func3==="b000".U && io.func7==="b0".U){
               io.AluControl:=10.U//beq
        }
        when(io.func3==="b001".U && io.func7==="b0".U){
               io.AluControl:=11.U//bne
        }
        when(io.func3==="b100".U && io.func7==="b0".U){
               io.AluControl:=12.U//blt
        }
        when(io.func3==="b101".U && io.func7==="b0".U){
               io.AluControl:=13.U//bge
        }
        when(io.func3==="b110".U && io.func7==="b0".U){
               io.AluControl:=14.U//bltu
        }
       
        when(io.func3==="b111".U && io.func7==="b0".U){
               io.AluControl:=15.U//bgeu
        }

    }
    .elsewhen(io.AluOp==="b110".U){
         
            io.AluControl:=21.U
            
     
    }
    
    //U type implement
}
//  io.AluOp:="b110".U
        