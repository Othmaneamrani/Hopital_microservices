package micro.test.chambre.kafka;

import lombok.*;

    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    @Getter
    @Setter
    public class Notif {
        private int id;
        private String data;
    }

