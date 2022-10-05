package SingleCycle
import chisel3._
import org.scalatest._
import chiseltest._
import chiseltest.internal.VerilatorBackendAnnotation
import chiseltest.experimental.TestOptionBuilder._

class DataMemory extends FreeSpec with ChiselScalatestTester{
    "Datamemory single cycle" in {
        test(new Data_Memory1()){
            c=>
            c.io.wr_en.poke(1.B)
            c.io.memRead.poke(1.B)
            c.io.DataIn.poke(2.S)
            c.io.memAdd.poke(1.U)
         
            c.clock.step(1)
            c.io.dataOut.expect(2.S)
        }
    }
}
 
     