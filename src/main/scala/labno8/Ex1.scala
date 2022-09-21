package labno8
import chisel3 . _
import chisel3.util._
class MaskedReadWriteSmem extends Module {
val width : Int = 8
val io = IO ( new Bundle {
val enable = Input ( Bool () )
val write = Input ( Bool () )
val addr = Input ( UInt (10. W ) )
val mask = Input ( Vec (4 , Bool () ) )
val dataIn = Input ( Vec (4 , UInt ( width . W ) ) )
val dataOut = Output ( Vec (4 , UInt ( width . W ) ) )
})
// Create a 32 - bit wide memory that is byte - masked
val mem = SyncReadMem (1024 , Vec (4 , UInt ( width . W ) ) )
 val connector= Wire ( Vec (4 , UInt( 8 . W ) ) )

when (io.mask(0)===1.U){

connector(0):=io.dataIn(0)
}
.otherwise{
    connector(0):=0.U
    
    
}
when (io.mask(1)===1.U){

connector(1):=io.dataIn(1)
}
.otherwise{
    connector(1):=0.U
    
    
}
when (io.mask(2)===1.U){

connector(2):=io.dataIn(2)
}
.otherwise{
    connector(2):=0.U
    
    
}
when (io.mask(3)===1.B){

connector(3):=io.dataIn(3)
}
.otherwise{
    connector(3):=0.U
    
    
}
mem . write ( io . addr , connector  )
io . dataOut := mem.read ( io . addr , io . enable )
}
