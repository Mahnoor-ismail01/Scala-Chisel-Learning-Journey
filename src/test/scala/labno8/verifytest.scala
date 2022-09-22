package labno8
import chisel3._
import org.scalatest._
import chiseltest._
import chiseltest.internal.VerilatorBackendAnnotation
import chiseltest.experimental.TestOptionBuilder._

class verify extends FreeSpec with ChiselScalatestTester{
    "lab8" in {
        test(new Parameterized_Mem()){
            c=>
           c.io.dataIn.poke(12.U) 
        
        c.io.addr.poke(1.U) 
        c.io.rd_enable.poke(1.B) 
        c.io.wr_enable.poke(1.B)
            c.clock.step(1)
            c.io.dataIn.poke(14.U) 
        
        c.io.addr.poke(1.U) 
        c.io.rd_enable.poke(1.B) 
        c.io.wr_enable.poke(1.B)
            c.io.dataOut.expect(1.U)
        }
    }
}