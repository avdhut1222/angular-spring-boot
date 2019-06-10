import {CircuitDetails} from "./circuit-details";
import {AdministrativeInformation} from "./administrative-information";
import {DesignInformation} from "./design-information";
import {EndUserTermination} from "./end-user-termination";
import {DlrNote} from "./dlr-note";
import {DesignLine} from "./design-line";
import {CircuitXrefInfo} from "./circuit-xref-info";

export interface ConnectionDesignDetails {
    populated: boolean;
    clrNotes: string;
    administrativeInformation: AdministrativeInformation;
    designInformation: DesignInformation;
    endUserTermination: EndUserTermination;
    dlrNotes: DlrNote[];
    designLines: DesignLine[];
    circuitXrefInfoList: CircuitXrefInfo[];
}
