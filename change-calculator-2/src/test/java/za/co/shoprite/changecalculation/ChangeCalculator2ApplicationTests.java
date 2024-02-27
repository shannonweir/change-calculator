package za.co.shoprite.changecalculation;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.assertThat;

import za.co.shoprite.changecalculation.enums.Denomination;
import za.co.shoprite.changecalculation.service.ChangeCalculationService;
import za.co.shoprite.changecalculation.utils.Utils;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class ChangeCalculator2ApplicationTests {

    @Autowired
    private ChangeCalculationService changeCalculationService;

    @Test
    public void calculateChange() {
        BigDecimal change = Utils.calculateChange(new BigDecimal(50), new BigDecimal(100));
        assertThat(change).isEqualTo(new BigDecimal(50));
    }

    @Test
    public void generateMapOf() {
        Map<Denomination, Integer> resultMap = new LinkedHashMap<>();
        resultMap.put(Denomination.TWO_HUNDRED_RAND, 1);
        resultMap.put(Denomination.TWENTY_RAND, 2);
        resultMap.put(Denomination.FIVE_RAND, 1);
        resultMap.put(Denomination.FIFTY_CENT, 1);
        resultMap.put(Denomination.TEN_CENT, 1);

        Map<Denomination, Integer> denominationIntegerMap = Utils.generateMapOf(new BigDecimal("245.60"));
        assertThat(denominationIntegerMap).isEqualTo(resultMap);
    }

    @Test
    public void logCalc() {
        changeCalculationService.calculateChange();
    }
}
