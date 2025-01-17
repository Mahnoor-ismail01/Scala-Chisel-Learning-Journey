package labno3
import chisel3._
import org.scalatest._
import chiseltest._

class ValidDecoder extends FreeSpec with ChiselScalatestTester{
    "testlabno3" in {
        test(new decoder_with_valid()){
            c=>
            c.io.in.poke(1.U)
            c.clock.step(1)
            c.io.out.valid.expect(1.B)
            c.io.out.bits.expect(1.U)
        }
    }
}