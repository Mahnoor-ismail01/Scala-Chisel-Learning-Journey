package labno8
import chisel3._
import org.scalatest._
import chiseltest._
import chiseltest.internal.VerilatorBackendAnnotation
import chiseltest.experimental.TestOptionBuilder._

class Maskreadtest extends FreeSpec with ChiselScalatestTester{
    "ex1lab8" in {
        test(new MaskedReadWriteSmem()){
            c=>
            c.io.enable.poke(1.B)
            c.io.addr.poke(1.U)
            c.io.write.poke(1.B)
            
            c.io.dataIn(0).poke(3.U)
            c.clock.step(1)
            c.io.dataOut(0).expect(3.U)
        }
    }
}