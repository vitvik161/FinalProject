package org.example.server.processing.controller;

import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.example.server.processing.CardDTO;
import org.example.server.processing.CustDTO;
import org.example.server.processing.service.CustService;
import org.springframework.web.bind.annotation.*;
import org.example.common.Response;
import org.example.common.Request;

import java.util.List;

@RestController
@AllArgsConstructor
@Log
public class Controller {

    private CustService custService;

    @GetMapping("/hosts/{hostId}/customers/{custId}")
    public CustDTO getByIdCustomerInfo(@PathVariable Long hostId, @PathVariable("custId") Long custId) {
        if (hostId != 1) {
            throw new RuntimeException();
        }
        return custService.getCustDTO(custId);
    }

    @GetMapping("/hosts/{hostId}/customers")
    public List<CustDTO> getAllCustomersInfo(@PathVariable Long hostId) {
        if (hostId != 1) {
            throw new RuntimeException();
        }
        return custService.getAllCustDTO();
    }

    @GetMapping("/hosts/{hostId}/cards/{cardPan}")
    public CardDTO getCardInfo(@PathVariable Long hostId, @PathVariable("cardPan") String cardPan) {
        if (hostId != 1) {
            throw new RuntimeException();
        }
        return custService.getCardDTO(cardPan);
    }

    @PostMapping("/hosts/{hostId}/cards/{cardPan}/pins/{cardPin}")
    public Response getBalance(@PathVariable("hostId") Long hostId,
                               @PathVariable("cardPan") String cardPan,
                               @PathVariable("cardPin") int cardPin,
                               @RequestBody Request request) {
        if (hostId != 1) {
            throw new RuntimeException();
        }

        log.info(request.toString());
        Response response = custService.getCardDTObalance(cardPan,cardPin);
        log.info(response.toString());
        return response;
    }

}
