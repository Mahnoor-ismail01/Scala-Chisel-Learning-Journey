package labno5
import chisel3._
import chiseltest._
import org.scalatest._
import chiseltest.internal.VerilatorBackendAnnotation
import chiseltest.experimental.TestOptionBuilder._

class advanceparam extends FreeSpec with ChiselScalatestTester{
    "lab5advamce param" in {
        test(new Operator(3 , UInt
(16.W) ) ( _ + _  )){
            c=>
            c.io.in(0).poke(1.U)
            c.io.in(1).poke(1.U)
             c.io.in(2).poke(1.U)
            c.clock.step(1)
            c.io.out(0).expect(3.U)
            c.io.out(1).expect(3.U)
            c.io.out(2).expect(3.U)

        }
    }
}