package pfe.springboot.services.participant;

import pfe.springboot.entities.participant;

public interface participantserviceinter {
    participant addparticipant(participant f);

    participant updatePart(Long id_participant, participant updateProf);

    // participant userid(Long id_participant, participant prof);

    void deleteparticipant(Long id_participant);

    // public participant activateparticipant(Long id);

    // public participant deactivateparticipant(Long id);
}
