package pl.slupski.testable;

import java.util.UUID;
import org.springframework.stereotype.Service;
import pl.slupski.controller.pojo.Client;
import pl.slupski.model.mappers.ClientMapper;

/**
 *
 * @author Przemysław Słupski <przemyslaw.slupski.98@gmail.com>
 */
@Service
public class ClientTestable extends Testable<Client> {

    private ClientMapper clientMapper;

    public ClientTestable(ClientMapper clientMapper) {
        this.clientMapper = clientMapper;
    }

    @Override
    public Client randomize(boolean save) {
        Client result = new Client(UUID.randomUUID().toString().substring(0, 8), UUID.randomUUID().toString());
        if (save) {
            clientMapper.insert(result);
        }
        return result;
    }

}
