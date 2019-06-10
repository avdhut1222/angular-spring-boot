import {OrderDetail} from './order-detail';
import {UserDefinedField} from './user-defined-field';
import {Contact} from './contact';
import {GlobalServiceLocationProduct} from './global-service-location-product';
import {TrunkGroup} from './trunk-group';
import {PicModel} from './pic-model';
import {TnFeature} from './tn-feature';
import {HuntGroup} from './hunt-group';
import {PsrServiceLocation} from './psr-service-location';
import {ChildSr} from './child-sr';
import {PsrNote} from './psr-note';
import {SrHierarchy} from "./sr-hierarchy";

export interface PsrDetail {
    orderDetailInformation: OrderDetail;
    userDefinedFields: UserDefinedField[];
    contacts: Contact[];
    psrServiceLocation: PsrServiceLocation;
    childSRs: ChildSr;
    globalServiceLocationProducts: GlobalServiceLocationProduct[];
    trunkGroups: TrunkGroup[];
    picInformation: PicModel[];
    tnFeatures: TnFeature[];
    huntGroups: HuntGroup[];
    notes: PsrNote[];
    srHierarchies: SrHierarchy[]
}
