package sem3.cars.api;

import sem3.cars.dto.MemberRequest;
import sem3.cars.dto.MemberResponse;
import sem3.cars.service.MemberService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/members")
public class MemberController {
    
    MemberService memberService;
    
    public MemberController(MemberService memberService){
        this.memberService = memberService;
    }
    
    //Security Admin Only
    @GetMapping()
    List<MemberResponse> getMembers(){
       return memberService.getMembersV2(false, false); 
    }
    
    //Security ADMIN
    @GetMapping(path = "/{username}")
    MemberResponse getMemberById(@PathVariable String username) throws Exception{
        return memberService.findById(username);
    }
    
    //Security ADMIN
    @PostMapping()
    MemberResponse addMember(@RequestBody MemberRequest body){
        return memberService.addMember(body);
    }
        
    //Security ADMIN
    @PutMapping("/{username}")
    void editMember(@RequestBody MemberRequest body, @PathVariable String username){
        memberService.editMember(body, username);
    }
    
    //Security ADMIN
    @PatchMapping("ranking/{username}/{value}")
    void setRankingForUser(@PathVariable String username, @PathVariable int value){
        memberService.setRankingForUser(username, value);
    }
    
    @DeleteMapping("/{username}")
    void deleteMemberByUsername(@PathVariable String username){
        memberService.deleteMemberByUsername(username);
    }
    
    
    
}
