package labno8
import chisel3 . _
import chisel3 . util . _
class memory_assignment extends Module {
val io = IO ( new Bundle {
    
val memory_out =   Output ( UInt (32. W ) ) 
val requestor = Vec (4 , Flipped ( Decoupled ( UInt (32. W ) ) ) )
val Readaddr = Input ( UInt (5. W ) )
val Writeaddr = Input ( UInt (5. W ) )
})
 val arbitor = Module(new Arbiter(UInt(), 4))
 val mem = SyncReadMem (1024 , UInt (32. W ) ) 



    arbitor.io.in(0) <> Queue(io.requestor(0))
    arbitor.io.in(1) <> Queue(io.requestor(1))
    arbitor.io.in(2) <> Queue(io.requestor(2))
    arbitor.io.in(3) <> Queue(io.requestor(3))
    arbitor.io.out.ready:=1.B

    mem.write ( io .Writeaddr , arbitor.io.out.bits)
io.memory_out := mem . read ( io .Readaddr  )

}