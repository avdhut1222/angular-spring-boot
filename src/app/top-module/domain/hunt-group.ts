import {HuntGroupDetail} from './hunt-group-detail';

export interface HuntGroup {
    huntGroupType: string;
    status: string;
    name: string;
    number: string;
    details: HuntGroupDetail[];
}
