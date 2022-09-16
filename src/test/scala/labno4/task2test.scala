package labno4
import chisel3._
import chiseltest._
import org.scalatest._
import chiseltest.experimental.TestOptionBuilder._
import chiseltest.internal.VerilatorBackendAnnotation
import scala.util.Random

class TestImmediate extends FreeSpec with ChiselScalatestTester{
    "testlabno4" in {
        test(new ImmdValGen1()){
            c=>
           val  array_ins=Array("h00918093")
            //array_l=Array(9)
            for (i<-0 until 100){
                //val src_a=Random.nextLong () & 0xFFFFFFFFL
                val opr = Random.nextInt(1)
                val aluop = array_ins(0)
            var result = aluop match{
                case "h00918093"=> 9
               
            }
            c.io.instr.poke(aluop.U)
            c.clock.step(1)
            c.io.immd_se.expect(result.U)
            }
        }
    }
}
