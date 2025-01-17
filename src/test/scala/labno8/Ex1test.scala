package labno8
import chisel3._
import org.scalatest._
import chiseltest._
import chiseltest.internal.VerilatorBackendAnnotation
import chiseltest.experimental.TestOptionBuilder._
//////
class Maskreadtest extends FreeSpec with ChiselScalatestTester{
    "ex1lab8" in {
        test(new MaskedReadWriteSmem()){
            c=>
            c.io.enable.poke(1.B)
            c.io.addr.poke(1.U)
            c.io.write.poke(1.B)
            c.io.mask(0).poke(1.B)
            c.io.mask(1).poke(0.B)
            c.io.mask(2).poke(1.B)
            c.io.mask(3).poke(1.B)
            c.io.dataIn(0).poke(0.U)
            c.io.dataIn(1).poke(1.U)
            c.io.dataIn(2).poke(3.U)
            c.io.dataIn(3).poke(0.U)
            
            c.clock.step(1)
            c.io.dataOut(0).expect(0.U)
            c.io.dataOut(1).expect(0.U)
            c.io.dataOut(2).expect(3.U)
            c.io.dataOut(3).expect(0.U)
        }
    }
}