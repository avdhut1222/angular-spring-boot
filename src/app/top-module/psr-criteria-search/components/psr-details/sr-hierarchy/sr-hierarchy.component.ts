import {Component, OnInit} from '@angular/core';
import {PsrSearchService} from '../../../service/psr-search.service';
import {SrHierarchy} from '../../../../domain/sr-hierarchy';

@Component({
    selector: 'app-sr-hierarchy',
    templateUrl: './sr-hierarchy.component.html',
    styleUrls: ['./sr-hierarchy.component.scss']
})
export class SrHierarchyComponent implements OnInit {

    constructor(protected psrSearchService: PsrSearchService) {
    }

    ngOnInit() {
    }

    renderTopLink(srHierarchy: SrHierarchy, parentFlag: boolean): string {
        let returnString = '';
        let identifier = '';
        let orderType = '';

        if (parentFlag) {
            orderType = srHierarchy.parentType;
        } else {
            orderType = srHierarchy.childType;
        }

        identifier = this.getIdentifierValue(srHierarchy, parentFlag);

        switch (orderType) {
            case 'SO':
                returnString += '/top/psr-details/' + identifier;
                break;
            case 'ISR':
                returnString += 'http://tbsapps/isrtbspreview_lookup_rsp.asp?ordnum=' + identifier
                    + '&CHKCIRCUIT=on&db=xo&CHKTASK=on&CHKNOTE=on';
                break;
            case 'LSR':
                returnString += 'http://tbsapps/LSRtbspreview_lookup_rsp.asp?ponNum=' + identifier;
                break;
            case 'ASR':
                returnString += 'http://tbsapps/xo_tbspreview_asr_rsp.asp?asr=' + identifier;
                break;
        }

        return returnString;
    }

    getIdentifierValue(srHierarchy: SrHierarchy, parentFlag: boolean): string {
        let identifier = '';
        let orderType = '';
        if (parentFlag) {
            identifier = srHierarchy.parentSr;
        } else {
            orderType = srHierarchy.childType;
            switch (orderType) {
                case 'SO':
                    identifier = srHierarchy.childSr;
                    break;
                case 'ISR':
                    identifier = srHierarchy.childOrdNbr;
                    break;
                case 'LSR':
                    identifier = srHierarchy.childPon;
                    break;
                case 'ASR':
                    identifier = srHierarchy.childPon;
                    break;
            }
        }
        return identifier;
    }

    calculateChildPadding(srHierarchyLevel: string): string {
        let levelNum: number = +srHierarchyLevel;
        if(levelNum > 0){
            let childPadding = levelNum * 10;
            let retStr = childPadding + 'px';
            return retStr;
        }
        return '';
    }

}
