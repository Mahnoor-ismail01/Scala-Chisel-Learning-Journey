package labno5
import chisel3._
import org.scalatest._
import chiseltest._
import chiseltest.internal.VerilatorBackendAnnotation
import chiseltest.experimental.TestOptionBuilder._

class Paramemuxtest extends FreeSpec with ChiselScalatestTester{
    "lab5task3" in{
        test (new paramEmux ( SInt (2. W ))( SInt (2. W )) ){
            c=>
            c.io.io1.poke(1.S)
             c.io.io2.poke(1.S)
            c.clock.step(1)
            c.io.out.expect(1.S)
        }
    }
}